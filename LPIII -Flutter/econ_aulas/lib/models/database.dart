import 'package:cloud_firestore/cloud_firestore.dart';

FirebaseFirestore _firestore = FirebaseFirestore.instance;
CollectionReference _reference = _firestore.collection("academico");

class Database {}
