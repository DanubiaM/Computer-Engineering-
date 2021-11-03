import 'package:econ_aulas/screens/list_screen.dart';
import 'package:flutter/material.dart';

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
    );
  }
}
