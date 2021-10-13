
    myTable.onclick = function(e) {
      if (e.target.tagName != 'TH') return;

      let th = e.target;
      // if TH, then sort
      // cellIndex is the number of th:
      //   0 for the first column
      //   1 for the second column, etc
      sortTable(th.cellIndex, th.dataset.type);
    };

    function sortTable(colNum, type) {
      let tbody = myTable.querySelector('tbody');

      let rowsArray = Array.from(tbody.rows);

      // compare(a, b) compares two rows, need for sorting
      let compare;

      switch (type) {
        case 'number':
          compare = function(rowA, rowB) {
            return rowA.cells[colNum].innerHTML - rowB.cells[colNum].innerHTML;
          };
          break;
        case 'string':
          compare = function(rowA, rowB) {
            return rowA.cells[colNum].innerHTML > rowB.cells[colNum].innerHTML ? 1 : -1;
          };
          break;
      }

      // sort
      rowsArray.sort(compare);

      tbody.append(...rowsArray);
    }