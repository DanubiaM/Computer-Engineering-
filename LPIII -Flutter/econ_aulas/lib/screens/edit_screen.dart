import 'package:econ_aulas/models/database.dart';
import 'package:flutter/material.dart';

class EditScreen extends StatefulWidget {
  const EditScreen(
      {Key? key,
      required this.name,
      required this.socialMedia,
      required this.id})
      : super(key: key);

  final String id;
  final String name;
  final String socialMedia;
  @override
  _EditScreenState createState() => _EditScreenState();
}

class _EditScreenState extends State<EditScreen> {
  //Para crir um 'momento/instante' para exibir os nome vindo do list_screen na tela
  @override
  void initState() {
    //widget usado devido ser uma variavel da classe
    nameController = TextEditingController(text: widget.name);
    socialMediaController = TextEditingController(text: widget.socialMedia);

    super.initState();
  }

  //late pois ele nao pode ficar sme receber nenhum valor, lgoo diz que vai receber valores depois
  late TextEditingController nameController;
  late TextEditingController socialMediaController;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.blueGrey.shade200,
        appBar: AppBar(
          backgroundColor: Color(0xFF36311f),
          title: Text("Pesistence + Firebase"),
          actions: [
            IconButton(
              icon: Icon(
                Icons.delete,
                color: Colors.redAccent,
                size: 30,
              ),
              onPressed: () {},
            )
          ],
        ),
        body: Padding(
          padding:
              const EdgeInsets.only(left: 20, top: 60, right: 20, bottom: 10),
          child: Form(
            //ListView é utilizado para caso o teclado ocupe muito espaço na tela nao apareça erro
            child: ListView(
              children: [
                Center(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text("Nome"),
                      TextFormField(
                        controller: nameController,
                        keyboardType:
                            TextInputType.text, //tipo de dados do teclado
                        textInputAction: TextInputAction.next,
                      ),
                      SizedBox(
                        height: 30,
                      ),
                      Text("Social Media"),
                      TextFormField(
                        controller: socialMediaController,
                        keyboardType:
                            TextInputType.text, //tipo de dados do teclado
                        textInputAction: TextInputAction.next,
                      ),
                      SizedBox(
                        height: 30,
                      ),
                      Center(
                        child: ElevatedButton(
                          onPressed: () {
                            Database.updateStudent(
                                widget.id,
                                nameController.text,
                                socialMediaController.text);
                            Navigator.of(context).pop();
                          },
                          child: Text(
                            "Update",
                            style: TextStyle(
                              fontSize: 15,
                              fontWeight: FontWeight.bold,
                              color: Colors.white,
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ));
  }
}
