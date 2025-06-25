class Usuario{

  //variables
  String correo;
  String pass;
  String nombre;
  String? direccion;

  //constructores -> principal // el resto son nominales

  Usuario(this.nombre,this.correo,this.pass){
  }
  Usuario.sincorreo({required nombre, required pass,} this.direccion);


  //metodos

}