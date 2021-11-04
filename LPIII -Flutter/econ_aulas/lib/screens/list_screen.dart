import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:econ_aulas/models/database.dart';
import 'package:econ_aulas/screens/edit_screen.dart';
import 'package:flutter/material.dart';

class ListScreen extends StatelessWidget {
  const ListScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return StreamBuilder<QuerySnapshot>(
      stream: Database.studentsList(),
      builder: (context, snapshot) {
        if (snapshot.hasError) {
          return Text("There is no data in the database.");
        } else if (snapshot.hasData || snapshot.data != null) {
          return ListView.separated(
            //Docs pode retornar nulo, logo é adicionado !, garantido que caso nao tenha nada apareça nada mas nao deê erro
            itemCount: snapshot.data!.docs.length,
            separatorBuilder: (context, index) => SizedBox(
              height: 5,
            ),
            itemBuilder: (context, index) {
              String docId = snapshot.data!.docs[index].id;
              String name = snapshot.data!.docs[index].get('name');
              String socialMedia =
                  snapshot.data!.docs[index].get('socialMedia');
              // String sexo = snapshot.data!.docs[index].get('sexo');
              // int age = snapshot.data!.docs[index].get('age');
              return ListTile(
                title: Text(name),
                subtitle: Text(socialMedia),
                // trailing: Text(sexo),
                //  leading: Text(age.toString()),

                //Encaminha para outra tela ao clicar no campo ListTile
                onTap: () => Navigator.of(context).push(MaterialPageRoute(
                    builder: (context) => EditScreen(
                        id: docId, name: name, socialMedia: socialMedia))),
              );
            },
          );
        } else
          return Container();
      },
    );
  }
}
