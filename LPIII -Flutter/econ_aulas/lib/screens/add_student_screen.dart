import 'package:econ_aulas/models/database.dart';
import 'package:flutter/material.dart';

class AddStudentScreen extends StatefulWidget {
  const AddStudentScreen({Key? key}) : super(key: key);

  @override
  _AddStudentScreenState createState() => _AddStudentScreenState();
}

class _AddStudentScreenState extends State<AddStudentScreen> {
  TextEditingController _controllerName = TextEditingController();
  TextEditingController _controllerSocialMedia = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.limeAccent[50],
      body: Form(
          child: Padding(
        padding: const EdgeInsets.all(50.0),
        child: Column(
          children: [
            Text('Cadastro de Estudantes'),
            TextFormField(
              controller: _controllerName,
              decoration: InputDecoration(
                  labelText: "Name of Student",
                  labelStyle: TextStyle(color: Colors.blue),
                  hintText: 'Please, write student name'),
            ),
            TextFormField(
              controller: _controllerSocialMedia,
              decoration: InputDecoration(
                  labelText: "Social Media",
                  labelStyle: TextStyle(color: Colors.blue),
                  hintText: 'Please, enter with your social media'),
            ),
            SizedBox(
              height: 40,
            ),
            ElevatedButton(
              onPressed: () {
                Database.addStudent(
                    name: _controllerName.text,
                    socialMedia: _controllerSocialMedia.text);
                //Volta para a tela anterior ao clicar no botão
                Navigator.of(context).pop();
              },
              child: Text("Add"),
            )
          ],
        ),
      )),
    );
  }
}
