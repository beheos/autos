const validarArchivo = () => {
	var fileInput = document.getElementById('inputFile');
  	var file = fileInput.files[0];

  if (file) {
    var fileName = file.name;
    var fileType = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

    if (fileType === 'xls' || fileType === 'xlsx') {
      console.log('Archivo cargado:', fileName);
     	return true;
    } else {
     	return false;
    }
  } else {
     alert('No se ha cargado ningún archivo.');
  }
}