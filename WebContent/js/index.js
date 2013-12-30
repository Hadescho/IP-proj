/**
 * 
 */

$(document).ready(function(){
	var list = 0;
	$.get('http://localhost:8080/org.elsys.to-doList/todo/list', function(list){
		for(var i = 0;i < list.length; i++)
			
		{
			console.log(list[i]);
			var task = list[i].content;
			var formatedTask = "<div class=\"thumbnail task\"><p class=\"pull-left\">" + task + "</p><div class=\"glyphicon glyphicon-ok pull-right \" id=\"d"+ list[i].id +"\"></div><div class=\"glyphicon glyphicon-edit pull-right\" id=\"e"+list[i].id +"\"></div></div>";
			$('#taskHolder').append(formatedTask);
		}
	});
	$('#submit').click(function(){
		var task = $('#newTaskBox').val();
		task = "\""+ task + "\"";
		$.ajax({
			method:'POST',
			url:'todo/list/add',
			data:task,
			dataType:"json",
			contentType: 'application/json'
		}).done(function(){
			window.location.reload(false);
		});
	});
	$(document).on('click','.glyphicon-ok',function(){
		var id = $(this).attr('id').replace('d','');
		$.ajax({
			method:'DELETE',
			url:'todo/list/remove/' + id,
		}).done(function(){
			window.location.reload(false);
		});
	});
	$(document).on('click','.glyphicon-edit',function(){
		var $parent = $(this).parent('.task');
		var placeholder = $(this).siblings('.pull-left').text();
		var id = $(this).attr('id').replace('e','');
		$(this).siblings('.pull-left').hide();
		$(this).hide();
		
		$parent.append(
				'<div class="input-group pull-center">' +
				'<input type="text"class="form-control" data-id="'+id+'" id="editTaskBox" placeholder="'+ placeholder + '" value="'+ placeholder + '">' +
					'<span class="input-group-btn">'+
						'<button class="btn btn-default" id="edit">Edit</button>' +
					'</span>' +
				'</div>');
		$(document).on('click','#edit',function(){
			var id = $(this).parent().siblings("input").data("id");
			var task = $(this).parent().siblings("input").val();
			if(task !== ""){
				
				$.ajax({
					method:"PUT",
					url:'todo/list/edit/' + id,
					data: task,
					dataType:"json",
					contentType: 'application/json'
				}).done(function(){
					window.location.reload(false);
				});
				
			}
		});
	});
	
});


