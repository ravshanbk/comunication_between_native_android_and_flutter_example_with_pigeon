// Autogenerated from Pigeon (v18.0.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.example.pigeon_example;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression", "serial"})
public class Pigeon {

  /** Error class for passing custom error details to Flutter via a thrown PlatformException. */
  public static class FlutterError extends RuntimeException {

    /** The error code. */
    public final String code;

    /** The error details. Must be a datatype supported by the api codec. */
    public final Object details;

    public FlutterError(@NonNull String code, @Nullable String message, @Nullable Object details) 
    {
      super(message);
      this.code = code;
      this.details = details;
    }
  }

  @NonNull
  protected static ArrayList<Object> wrapError(@NonNull Throwable exception) {
    ArrayList<Object> errorList = new ArrayList<Object>(3);
    if (exception instanceof FlutterError) {
      FlutterError error = (FlutterError) exception;
      errorList.add(error.code);
      errorList.add(error.getMessage());
      errorList.add(error.details);
    } else {
      errorList.add(exception.toString());
      errorList.add(exception.getClass().getSimpleName());
      errorList.add(
        "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }
    return errorList;
  }

  @Target(METHOD)
  @Retention(CLASS)
  @interface CanIgnoreReturnValue {}

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class Book {
    private @Nullable String title;

    public @Nullable String getTitle() {
      return title;
    }

    public void setTitle(@Nullable String setterArg) {
      this.title = setterArg;
    }

    private @Nullable String imageUrl;

    public @Nullable String getImageUrl() {
      return imageUrl;
    }

    public void setImageUrl(@Nullable String setterArg) {
      this.imageUrl = setterArg;
    }

    public static final class Builder {

      private @Nullable String title;

      @CanIgnoreReturnValue
      public @NonNull Builder setTitle(@Nullable String setterArg) {
        this.title = setterArg;
        return this;
      }

      private @Nullable String imageUrl;

      @CanIgnoreReturnValue
      public @NonNull Builder setImageUrl(@Nullable String setterArg) {
        this.imageUrl = setterArg;
        return this;
      }

      public @NonNull Book build() {
        Book pigeonReturn = new Book();
        pigeonReturn.setTitle(title);
        pigeonReturn.setImageUrl(imageUrl);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<Object>(2);
      toListResult.add(title);
      toListResult.add(imageUrl);
      return toListResult;
    }

    static @NonNull Book fromList(@NonNull ArrayList<Object> list) {
      Book pigeonResult = new Book();
      Object title = list.get(0);
      pigeonResult.setTitle((String) title);
      Object imageUrl = list.get(1);
      pigeonResult.setImageUrl((String) imageUrl);
      return pigeonResult;
    }
  }

  private static class BookApiCodec extends StandardMessageCodec {
    public static final BookApiCodec INSTANCE = new BookApiCodec();

    private BookApiCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 128:
          return Book.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof Book) {
        stream.write(128);
        writeValue(stream, ((Book) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface BookApi {

    @NonNull 
    List<Book> searchBook(@NonNull String keyWord);

    /** The codec used by BookApi. */
    static @NonNull MessageCodec<Object> getCodec() {
      return BookApiCodec.INSTANCE;
    }
    /**Sets up an instance of `BookApi` to handle messages through the `binaryMessenger`. */
    static void setUp(@NonNull BinaryMessenger binaryMessenger, @Nullable BookApi api) {
      setUp(binaryMessenger, "", api);
    }
    static void setUp(@NonNull BinaryMessenger binaryMessenger, @NonNull String messageChannelSuffix, @Nullable BookApi api) {
      messageChannelSuffix = messageChannelSuffix.isEmpty() ? "" : "." + messageChannelSuffix;
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.pigeon_example.BookApi.searchBook" + messageChannelSuffix, getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                ArrayList<Object> args = (ArrayList<Object>) message;
                String keyWordArg = (String) args.get(0);
                try {
                  List<Book> output = api.searchBook(keyWordArg);
                  wrapped.add(0, output);
                }
 catch (Throwable exception) {
                  ArrayList<Object> wrappedError = wrapError(exception);
                  wrapped = wrappedError;
                }
                reply.reply(wrapped);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
}