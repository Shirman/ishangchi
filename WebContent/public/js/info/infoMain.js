/**
 * 
 */
$(function(){
	var isLoading = false;
	 $(window).scroll(function() {  
	      //当内容滚动到底部时加载新的内容  
	      if ($(window).scrollTop() + $(window).height() + 20 >= $(document).height() && $(this).scrollTop() > 20 && !isLoading) {  
	    	  isLoading = true;
	    	  loadMore();
	      }  
	  });  
	 
	 $("[data-icon='refresh']").click(function(){
		 var pageNum = 1;
		 var pageSize = 30;
		 var loading = "<div  style='text-align:center' name='loading'><span ><img alt='加载中...'  src='/ishangchi/public/images/loading.gif'></span></div>";
			if(!$("[name='loading']").length>0){
				 $("div[data-role='header']").after(loading);
			}
		 $.ajax({
			 url:"/ishangchi/rest/info/getArticles",
			 type:"get",
			 data:$.param({pageNum:pageNum,pageSize:pageSize}),
			 success:function(data){
				 $("[data-role='content']").remove();
				 generateHtml(data);
			 },
			 complete:function(){
				 isLoading = false;
				 $("[name='loading']").remove();
			 }
		 })
	 
	 })
	 
	 /**
	  * 自动加载更多
	  */
	 function loadMore(){
		 var pageNum = $('#pageNum').val()*1+1;
		 var pageSize = 30;
		 var loading = "<div  style='text-align:center' name='loading'><span ><img alt='加载中...'  src='/ishangchi/public/images/loading.gif'></span></div>";
		if(!$("[name='loading']").length>0){
			 $("div[data-role='footer']").before(loading);
		}
		 $.ajax({
			 url:"/ishangchi/rest/info/getArticles",
			 type:"get",
			 data:$.param({pageNum:pageNum,pageSize:pageSize}),
			 success:function(data){
				 $("[name='loading']").remove();
				 generateHtml(data);
				 $('#pageNum').val(pageNum);
			 },
			 complete:function(){
				 isLoading = false;
				 $("[name='loading']").remove();
			 }
		 })
	 }
	 
	 /**
	  * 生成文章内容
	  */
	 function generateHtml(data){
		 var articles = [];
		 try{
			 var articles = data.data.list;
		 }catch(e){
		 }
		if(articles.length>0){
			var articleArry = [];
			$.each(articles,function(index,ele){
				var title = ele.title;
				var content = ele.content;
				var author = ele.author;
				var html = "<div data-role='content' class='ui-content' role='main'>    	<ul data-role='listview' data-inset='true' class='ui-listview ui-listview-inset ui-corner-all ui-shadow'>      		<li data-icon='false' data-theme='e' class='ui-li-static ui-body-e ui-first-child ui-last-child'>        	<h2>"+title+"</h2>        	<p><b>作者："+author+"</b></p>        	<div class='ui-li-desc ui-li-no-toe' style='white-space: normal;'>"+content+"</div>      		</li>    	</ul>  	</div>"
				articleArry.push(html);
			})
			var articleHtml = articleArry.join("");
			$("div[data-role='footer']").before(articleHtml);
		}
	 
	 }
})