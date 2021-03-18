//Funcion que recolecta los datos ingresados en el formulario, crea un objeto y lo envía
//mediante el consumo del servicio en formato Json
function enviarDatos() {
    var persona = {
        nombre: document.getElementById("nombre").value,
        apellido: document.getElementById("apellido").value,
        procesado: document.getElementById("procesado").value
    };

    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/personas/crear";

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 201) {
            alert("Persona creada");
        }
    };
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.send(JSON.stringify(persona));
}