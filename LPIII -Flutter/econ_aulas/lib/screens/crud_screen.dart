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
        title: Text("Academy system"),
      ),
      body: ListScreen(),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
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
