//Segmento de codigo encargado en cosumir el servicio para obtener los datos
//que serán mostrados en la tabla del html.
//Está fuera de una funcion porque se necesita que los datos sean comsultados
//al momento de cargar la pagina.
var xmlhttp = new XMLHttpRequest();
var url = "http://localhost:8080/personas/consultar";
xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        var myArr = JSON.parse(this.responseText);
        console.log(myArr);
        crearTabla(myArr);
    }
};
xmlhttp.open("GET", url, true);
xmlhttp.send();


//Funcion que se encarga de crear una tabla dinamica en el .html en la cual se muestran
//todas las personas creadas en la anterior pagina
function crearTabla(datos) {
    var myTableDiv = document.getElementById("Creados");
    var table = document.createElement('TABLE');
    var tableBody = document.createElement('TBODY');

    table.border = '1';
    table.appendChild(tableBody);

    var columna = new Array();
    columna[0] = "Id";
    columna[1] = "Nombre";
    columna[2] = "Apellido";
    columna[3] = "Procesado";

    //COLUMNAS DE LA TABLA
    var tr = document.createElement('TR');
    tableBody.appendChild(tr);
    for (i = 0; i < columna.length; i++) {
        var th = document.createElement('TH');
        th.width = '75';
        th.appendChild(document.createTextNode(columna[i]));
        tr.appendChild(th);
    }

    //FILAS DE LA TABLA
    for (i = 0; i < datos.length; i++) {
        var tr = document.createElement('TR');
        //for (j = 0; j < datos.length; j++) {
        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(datos[i]["id"]));
        tr.appendChild(td);

        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(datos[i]["nombre"]));
        tr.appendChild(td);

        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(datos[i]["apellido"]));
        tr.appendChild(td);

        var td = document.createElement('TD');
        var x = document.createElement("INPUT");
        x.setAttribute("type", "checkbox");
        if (datos[i]["procesado"]) {
            x.setAttribute("checked", true);
        }
        td.appendChild(x);
        tr.appendChild(td);
        //}
        tableBody.appendChild(tr);
    }
    myTableDiv.appendChild(table);
}

//Funcion que se encarga de consumir el servicio de actualizacion del estado procesado de
//las personas seleccionadas
function procesarDatos() {

    var idSeleccionados = new Array();
    for (var i = 0; i < document.getElementsByTagName("TR").length - 1; i++) {
        if (document.getElementsByTagName("INPUT").item(i).checked) {
            idSeleccionados[i] = document.getElementsByTagName("TR").item(i + 1).cells[0].innerHTML;
        }
    }
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/personas/editar";

    xmlhttp.onreadystatechange = function() {
        if (this.status == 200) {
            location.reload();
        }
    };
    xmlhttp.open("PUT", url, true);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.send(JSON.stringify(idSeleccionados));
}