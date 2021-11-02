import 'package:cloud_firestore/cloud_firestore.dart';

//FirebaseFirestore permite acesso aos dados do banco firebase
FirebaseFirestore _firestore = FirebaseFirestore.instance; //instanciando
//referencia da coleção chamado academico
CollectionReference _reference = _firestore.collection("academico");

class Database {
  static late String userId;

  //metodo para adicionar dados no firebase
  addStudent(String name, String socialMedia, String sexo, int age) {
    //Dentro da coleção temos um documento que se chamara userId
    DocumentReference documentReference =
        _reference.doc(userId).collection('students').doc();

    //String refere-se aos nomes das 'colunas' e dynamic ao tipo de dado delas
    Map<String, dynamic> data = <String, dynamic>{
      "name": name,
      "socialMedia": socialMedia,
      "sexo": sexo,
      "age": age,
    };

    documentReference.set(data).whenComplete(() => print("Student saved!"));
  }
}
