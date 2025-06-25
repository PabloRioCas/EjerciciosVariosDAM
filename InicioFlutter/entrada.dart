//tipo de retorno nombreMetodo(){}

void main(){
  //variables tipadas
  String nombre="Pablo";
  String apellido ="Rios";
  String? direccion;
  int edad =40;
  late String correo;


  correo ="pr@gmail.com";

  //variable dinámica
  var telefono;

  telefono= "12454";
  telefono =12454;

  print("nombre $nombre Apellido: $apellido direccion ${direccion?? "Sin dirección"}");

  saludar(nombre, apellido, "Alcorcon");

  //un metodo en forma nominal
  saludarNominal(nombreP: nombre, apellidoP: apellido, direccionP: "Alcorcon");

}

//con void retorna vacio pero sin el void retorna algo dynamic
void saludar(String nombre, String apellido, String? direccion, [int telefono =00000]) {
  print("nombre $nombre Apellido: $apellido direccion ${direccion ??
      "Sin dirección"} Telefono: $telefono");
}

  saludarNominal(
      {required String nombreP ,
        required String apellidoP,
        required String direccionP,
        int telefono=0}) {
    print("nombre $nombreP Apellido: $apellidoP direccion ${direccionP} Telefono: $telefono");
  }