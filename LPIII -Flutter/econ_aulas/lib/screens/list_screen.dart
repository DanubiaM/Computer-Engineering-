import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:econ_aulas/models/database.dart';
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
              return ListTile(
                title: Text(name),
                subtitle: Text(socialMedia),
              );
            },
          );
        } else
          return Container();
      },
    );
  }
}
