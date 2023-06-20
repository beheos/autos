		var identificador = document.getElementById('identificador');
	    var tipoAutomovil = document.getElementById('tipoAutomovil');
	    var numeroSerie = document.getElementById('numeroSerie');
		var marca = document.getElementById('marca');
		var subMarca = document.getElementById('subMarca');
		var modelo = document.getElementById('modelo');
		var color = document.getElementById('color');
		var estado = document.getElementById('estado');
		var precio = document.getElementById('precio');
		var nPuertas = document.getElementById('nPuertas');
		var observaciones = document.getElementById('observaciones');
		var kilometraje = document.getElementById('kilometraje');
		var sucursal = document.getElementById('sucursal');

		marca.addEventListener('change', () => {
			getSubMarca(marca.value);
		});

	const getSubMarca = (idMarca, idSubmarca = "-1") => {
			fetch('/vehiculo/getSubMarcas/' + idMarca)
			.then(resp => resp.json())
			.then(result => {
				let selector = `<option value="-1">--SELECCIONAR--</option>`
				result.forEach(sub => {
					selector += '<option value="' + sub.id + '">' + sub.subMarca + '</option>';
			})
	 	 		subMarca.innerHTML = selector;
				if(idSubmarca != "-1"){
					subMarca.value = idSubmarca;	
				}
				
		})
	}
		
	const editar = id => {
		fetch('/vehiculo/editar/' + id)
		.then(resp => resp.json())
		.then(data => {
			identificador.value = data.id;
			sucursal.value = data.sucursal.id;
			tipoAutomovil.value = data.tipoAutomovil.id;
			numeroSerie.value = data.numeroSerie;
			marca.value = data.marca.id;
			getSubMarca(marca.value, data.subMarca.id);
			modelo.value = data.modelo;
			color.value = data.color.id;
			precio.value = data.precio;
			nPuertas.value = data.nPuertas;
			kilometraje.value = data.kilometraje;
			estado.value = data.estado.id;
			observaciones.value = data.observaciones;
		})
	}

	const limpiarCampos = () => {
		identificador.value = '';
		tipoAutomovil.value = '-1';
		numeroSerie.value = '';
		marca.value = '-1';
		getSubMarca(marca.value);
		modelo.value = '';
		color.value = '-1';
		estado.value = '-1'; 
		precio.value = '';
		nPuertas.value = '';
		observaciones.value = '';
		kilometraje.value = '';
		sucursal.value = '-1';
	}

	function validarFormulario() {
	      if (sucursal.value === '-1') {
	        sucursal.classList.add('is-invalid');
	        return false;
	      }else{
	      sucursal.classList.remove('is-invalid');
	      }

	      if (estado.value === '-1') {
	        estado.classList.add('is-invalid');
	        return false;
	      }else{
	        estado.classList.remove('is-invalid');
	      }

	      if (tipoAutomovil.value === '-1') {
	        tipoAutomovil.classList.add('is-invalid');
	        return false;
	      }else{
	        tipoAutomovil.classList.remove('is-invalid');
	      }

	      if (marca.value === '-1') {
	        marca.classList.add('is-invalid');
	        return false;
	      }else{
	        marca.classList.remove('is-invalid');
	      }

	      if (subMarca.value === '-1') {
	        subMarca.classList.add('is-invalid');
	        return false;
	      }else{
	    	 subMarca.classList.remove('is-invalid');
	      }

	      if (numeroSerie.value === '') {
	        numeroSerie.classList.add('is-invalid');
	        return false;
	      }else{
	        numeroSerie.classList.remove('is-invalid');
	      }

	      if (color.value === '-1') {
	        color.classList.add('is-invalid');
	        return false;
	      }else{
	        color.classList.remove('is-invalid');
	      }

	      if (nPuertas.value === '') {
	        nPuertas.classList.add('is-invalid');
	        return false;
	      }else{
	        nPuertas.classList.remove('is-invalid');
	      }

	      if (modelo.value === '') {
	        modelo.classList.add('is-invalid');
	        return false;
	      }else{
	        modelo.classList.remove('is-invalid');
	      }
	      
	      if (precio.value === '') {
	        precio.classList.add('is-invalid');
	        return false;
	      }else{
	        precio.classList.remove('is-invalid');
	      }
	      
	      if (kilometraje.value === '') {
	        kilometraje.classList.add('is-invalid');
	        return false;
	      }else{
	        kilometraje.classList.remove('is-invalid');
	    }
	      return true;
	    }