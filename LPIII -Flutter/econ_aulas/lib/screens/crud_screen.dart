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
      body: Container(
        child: Center(child: Text("List")),
      ),
    );
  }
}
