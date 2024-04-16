package com.example.pigeon_example

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import java.util.Random

class MainActivity : FlutterActivity() {
    private class MyBookApi : Pigeon.BookApi {
        override fun searchBook(keyWord: String): MutableList<Pigeon.Book> {
            val random = Random()
            val book = Pigeon.Book()
            book.imageUrl = "https://source.unsplash.com/random/?book?sig=" + random.nextInt()
            book.title = "ava.lang.StringBuffer(,keyWord)"
            return mutableListOf(book);
        }

    }


    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        Pigeon.BookApi.setUp(flutterEngine.dartExecutor.binaryMessenger, MyBookApi())
    }
}
