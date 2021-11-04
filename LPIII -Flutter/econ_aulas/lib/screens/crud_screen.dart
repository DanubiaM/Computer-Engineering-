import 'package:econ_aulas/screens/list_screen.dart';
import 'package:flutter/material.dart';

import 'add_student_screen.dart';

class CrudScreen extends StatelessWidget {
  const CrudScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text("Academy System"),
      ),
      body: ListScreen(),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          //push permite voltar para a pagina anterior
          Navigator.of(context).push(
            MaterialPageRoute(
              builder: (context) => AddStudentScreen(),
            ),
          );
        },
      ),
    );
  }
}
