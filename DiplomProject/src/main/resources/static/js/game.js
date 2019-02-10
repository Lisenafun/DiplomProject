console.log("a");


document.getElementById("table").addEventListener("click", tableHandler);
function tableHandler(e){
  alert(e.target.innerHTML);
}