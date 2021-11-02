import 'package:econ_aulas/models/database.dart';
import 'package:flutter/material.dart'; //disponibiliza todos os componentes
import 'package:firebase_core/firebase_core.dart';

import 'crud_screen.dart';
//'stf' starefull ja cria automaticamente

class LoginScreen extends StatefulWidget {
  final String title;
  //Construtor - title é um parametro que deve ser passado ao utilizar essa classe
  const LoginScreen({Key? key, required this.title}) : super(key: key);

  //criando um estado
  @override
  _LoginScreenState createState() => _LoginScreenState();
}

//Separando para controlar a classe
class _LoginScreenState extends State<LoginScreen> {
  TextEditingController _userIdController = TextEditingController();

  //Função build retorna um Widget
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: FutureBuilder(
          future: Database.initializerFirebase(),
          builder: (context, snapshot) {
            return Form(
              child: Column(
                children: [
                  SizedBox(
                    height: 200,
                  ),
                  Text(widget.title),
                  Padding(
                    padding: const EdgeInsets.symmetric(
                        horizontal: 20.0, vertical: 10),
                    child: TextFormField(
                      //Todo conteudo deste Form estara vinculado a variavel do controller "_userIdController"
                      controller: _userIdController,
                      style: TextStyle(color: Colors.lightBlue[900]),
                      decoration: InputDecoration(
                          labelStyle: TextStyle(color: Colors.blue),
                          labelText: "User name",
                          hintText: "Please, write your ID"),
                    ),
                  ),
                  ElevatedButton(
                      onPressed: () {
                        Database.userId = _userIdController.text;
                        Navigator.of(context).pushReplacement(MaterialPageRoute(
                            builder: (context) => CrudScreen()));
                        debugPrint("${_userIdController.text} log in");
                      },
                      child: Text("Log In"))
                ],
              ),
            );
          }),
    );
  }
}
