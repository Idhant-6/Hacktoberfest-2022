function dragImg(event){
    event.dataTransfer.setData("img",event.target.id +"|"+event.target.parentNode.id);
   }
   function dropImg(event){
       var data = event.dataTransfer.getData("img");
       // console.log(data)
       var dropItems = data.split("|"); 
       var prevElem = document.getElementById(dropItems[1]);
       // console.log(prevElem);
      console.log(prevElem.getElementsByTagName("div")[0].id =event.target.id);              
       event.target.id= dropItems[0]; 
       event.preventDefault(); 
   }