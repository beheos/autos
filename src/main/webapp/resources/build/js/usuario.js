var idUsuario = document.getElementById('idUsuario');
var username = document.getElementById('username');
var password = document.getElementById('password');
var mail = document.getElementById('mail');
var enabled = document.getElementById('enabled'); 
var rol1 = document.getElementById('rol1');
var rol2 = document.getElementById('rol2');
var rol3 = document.getElementById('rol3'); 


const editar = usuario => {
	fetch('/usuarios/editar/' + usuario)
		.then(resp => resp.json())
		.then(data => {
			console.log(data);
			idUsuario.value = data.usuario.id;
			username.value = data.usuario.username;
			mail.value = data.usuario.mail;
			enabled.value = data.usuario.enabled;
			perfiles(data.roles);
		})
}

const perfiles = roles => {
	roles.forEach(rol => {
		if(rol.rol == 'ADMIN')
			rol1.checked = true;
		else if (rol.rol == 'VENTAS')
			rol2.checked = true;
		else if (rol.rol == 'RH')
			rol3.checked = true;
	})
}