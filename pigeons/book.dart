import 'package:pigeon/pigeon.dart';
@ConfigurePigeon(PigeonOptions(
  dartOut: 'lib/dart_api.dart',
  javaOut: 'android/app/src/main/java/io/flutter/plugins/Pigeon.java',
  javaOptions: JavaOptions(package: 'com.example.pigeon_example'),




))
// usage: pigeon --input <pigeon path> --dart_out <dart path> [option]*

class Book {
  final String? title;
  final String? imageUrl;

  const Book({
    this.title,
    this.imageUrl,
  });
}



@HostApi()
abstract class BookApi {
  List<Book?> searchBook(String keyWord);
}
