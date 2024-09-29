$(function() {
    $(".js-load-books").on('click', function() {
        $.ajax({
            url: "http://localhost:8080/books",
            type: "get",
            headers: {
                "Authorization" : "Basic dXN1YXJpbzoxMjM0NTY="
            },
            success: function(response){
                drawTable(response);
            }
        });
    })
});

function drawTable(data) {
    $(".js-books-table-body tr").remove();
    for(var i = 0; i < data.length; i++) {
        drawLine(data[i]);
    }
}

function drawLine(line) {
    var tableLine = $("<tr/>");
    $(".js-books-table-body").append(tableLine);
    tableLine.append("<td>" + line.id + "</td>");
    tableLine.append("<td>" + line.name + "</td>");
    tableLine.append("<td>" + line.publication + "</td>");
    tableLine.append("<td>" + line.publisher + "</td>");
    tableLine.append("<td>" + line.summary + "</td>");
}