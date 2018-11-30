$(document).ready(function(){
    var key = encodeURI("東野圭吾");
    var max = 40;
    var start = 0;

    $("#content").click(function(){
        //検索文字
        key = encodeURI($("#q").val());
        //ページング
        start = $("#page option:selected").val();
        if(start >= 1){start = max * start;}
        console.log(start);
    	//取得件数
    	//max = $("#max option:selected").val();
    	book_search(key,max,start);
    });
});

function book_search(key,max,start){
	var items = null;
	var obj = null;
	$.ajax({
       type : "GET",
       url : "https://www.googleapis.com/books/v1/volumes",
       data: "q=" + key + "&country=JP&maxResults=" + max + "&startIndex=" + start,
       dataType: "jsonp",
       success: function(data){
           obj = data;
           items = obj.items;
           console.log(items);
           var text = "<p>タイトルをクリックすると収蔵図書館を検索します。</br><hr>";
           for(var i = 0; i < items.length; i++){

        	   if(items[i].volumeInfo.imageLinks === undefined){
        		   console.log('imageLinks === undefined');
        		   continue;
        	   }else{
        		   console.log(items[i].volumeInfo.industryIdentifiers[0].identifier)
              text = text + '<span id="book' + i + '"><a href="javascript:void(0)"><font color="blue">【タイトル】' + items[i].volumeInfo.title +
              '</font></a></span></br><img src="' + items[i].volumeInfo.imageLinks.thumbnail + '" width="20%"/>' +
              '</span></br>【説明】' + items[i].volumeInfo.description +
              '</span></br>【著者】' + items[i].volumeInfo.authors +
              '</br>【ISBN】' + items[i].volumeInfo.industryIdentifiers[0].identifier +
              '</br>------------------------------------------------------------------</br>';
              }
           }
           $('#contents').append(text + '</p>');
           $('#contents').append("----------------");
           $('#contents span').bind('click',function(){
        	  attr_id = $(this).attr('id').substring(4);
              $('form').append('<input type="hidden" name="book_title" value="' + items[attr_id].volumeInfo.title + '">');
              $('form').append('<input type="hidden" name="book_isbn10" value="' + items[attr_id].volumeInfo.industryIdentifiers[0].identifier + '">');
              $('form').append('<input type="hidden" name="book_isbn13" value="' + items[attr_id].volumeInfo.industryIdentifiers[0].identifier + '">');
              console.log(document.bindForm.submit());
           });
      }
    });

}