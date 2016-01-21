# Table tr swap 

```js 
var swapRows = function(a, b) {
  var columnsT = document.getElementById("columnsTable");
  var rows = columnsT.rows;

  var row = rows[a],
      sibling = row.previousElementSibling,
      anchor  = row.nextElementSibling,
      parent  = row.parentNode;
  if (b == "down") {
    var row = rows[a+1],
      sibling = row.previousElementSibling,
      anchor  = row.nextElementSibling,
      parent  = row.parentNode;
    parent.insertBefore(row, sibling);
  } else {
    parent.insertBefore(row, sibling);
  }

}  
``` 

