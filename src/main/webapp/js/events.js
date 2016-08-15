

app.userEvents.newclientDatasourceOnAfterFill = function(event) {
	console.log('carregando a tela de cadastro de clientes');
	event.active = {};
	event.inserting = true;
	return true;
}

app.userEvents.newclientDatasourceOnAfterCreate = function(event) {
	return true;
}