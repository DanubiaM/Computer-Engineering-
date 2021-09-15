//Classe com estado
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  @override
  State<HomePage> createState() {
    return HomePageState();
  }
}

//Estado
class HomePageState extends State<HomePage> {
  int counter = 0;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(title: Text('Home Page')),
      body: Center(
          child: GestureDetector(
        child: Text('Contador: $counter', style: TextStyle(fontSize: 20)),
        onTap: () {
          //Método para inserir valores que serão modificados
          setState(() {
            counter++;
          });
          print(counter);
        },
      )),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          setState(() {
            counter++;
          });
        },
      ),
    );
  }
}
