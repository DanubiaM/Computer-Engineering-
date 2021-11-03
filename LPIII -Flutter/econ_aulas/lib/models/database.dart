import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_core/firebase_core.dart';

//FirebaseFirestore permite acesso aos dados do banco firebase
FirebaseFirestore _firestore = FirebaseFirestore.instance; //instanciando
//referencia da coleção chamado academico
CollectionReference _reference = _firestore.collection("academico");

class Database {
  static late String userId;

  //metodo para adicionar dados no firebase
  static addStudent(
      {
      // '?' faz com que seja aceitado valores nullable
      required String name,
      required String socialMedia,
      String? sexo,
      int? age}) async {
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

    await documentReference
        .set(data)
        .whenComplete(() => print("Student saved!"));
  }

  static Stream<QuerySnapshot> studentsList() {
    CollectionReference studentsCollection =
        _reference.doc(userId).collection('students');
    return studentsCollection.snapshots();
  }

  //inicializado base de dados de forma assincrona, podendo executar outros apps ao mesmo tempo que busca no bd
  static Future<FirebaseApp> initializerFirebase() async {
    FirebaseApp firebaseApp = await Firebase.initializeApp();
    return firebaseApp;
  }
}
