import 'package:flutter/material.dart';
import 'package:pigeon_example/dart_api.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const SearchBook(),
    );
  }
}

class SearchBook extends StatefulWidget {
  const SearchBook({super.key});

  @override
  State<SearchBook> createState() => _SearchBookState();
}

class _SearchBookState extends State<SearchBook> {
  List<Book> books = [];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Center(
        child: Column(
          children: [
            Expanded(
              child: PageView.builder(
                itemCount: books.length,
                itemBuilder: (context, index) {
                  return Column(
                    children: [
                      Expanded(child: Image.network(books[index].imageUrl!)),
                      Text(books[index].title!),
                    ],
                  );
                },
              ),
            ),
            ElevatedButton(
                onPressed: searchBook, child: const Text('Search book'))
          ],
        ),
      ),
    );
  }

  void searchBook() async {
    final i = this.books.length + 1;
    final List<Book?> books = await BookApi().searchBook('keyWord $i');
    final List<Book> newBoks = List<Book>.from(books);
    setState(() {
      this.books.addAll(newBoks);
    });
  }
}
