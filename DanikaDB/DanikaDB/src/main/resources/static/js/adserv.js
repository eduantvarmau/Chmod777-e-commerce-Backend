//GET PRODUCTOS

  async function fetchDataAsync(url){
      try{
          let respuesta = await fetch(url);
          let productos = await respuesta.json();
          return productos
      }catch(error){
          return error
      }
  }
  function crearTarjeta(producto){
  

      let cardProducto = `
      <div class="col mb-4"
            <div class="card">
                    <img src="./../img/serv/${producto.url_imagen}" class="card-img-top alt="...">
                    <div class="card-body card-bodyy ">
                    <h5 class="card-titles titleStyleCard">${producto.nombre}</h5>
                    <p class="card-texts">${producto.descripcion}</p>
                    </div>
                    <div class="card-button">
                    <a href="#" class="btn btn-col btnDef">Agendar</a>
                    </div>
            </div>      
            </div>
      `;
      return cardProducto;
  }
  function crearTarjetas(arrayProductos){
      let ancla = document.getElementById("anclaservicios");
      let acumulador = "";
      arrayProductos.forEach(element => {
 
          let nuevaTarjeta =  crearTarjeta(element);
  
         acumulador = acumulador + nuevaTarjeta;
  
      });
      ancla.innerHTML = acumulador;
  }

  window.onload =function(){
      let url = "http://localhost:8080/api/productos/";
  
      let datos = fetchDataAsync(url);
      datos
      .then(productos =>{
          crearTarjetas(productos);
      })
      .catch(error => {
          console.error(error)
      })
  
  }


	 
//POST CREACIÓN DE PRODUCTO


//POST REGISTRO USUARIO




const url ="http://localhost:8080/api/usuarios/";
const myForm = document.querySelector("form-registro");

myForm.addEventListener("submit", async (e)=>{
	e.preventDefault();
	const formData = new FormData(myForm);
	const formDataSerialized = Object.fromEntries(formData);
	const jsonObject ={
		...formDataSerialized,
		sendToSelf: formDataSerialized.sendToSelf ? true : false,
	};
	
	try{
		const response = await fetch (url,{
			method: "POST",
			body: JSON.stringify(jsonObject),
			headers:{
				"Content-Type": "application/json",
			},
		});
		const json = await response.json();
		console.log(json);
	}catch(e){
		console.error(e);
		alert("there as an error")
	}
	
});



//POST INICIO DE SESIÓN

