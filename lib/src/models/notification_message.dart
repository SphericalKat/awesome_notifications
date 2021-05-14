import 'package:awesome_notifications/awesome_notifications.dart';
import 'package:awesome_notifications/src/models/model.dart';

class NotificationMessage extends Model {
  String? name;
  String? body;
  String? icon;

  NotificationMessage({this.body, this.icon, this.name});

  @override
  NotificationMessage? fromMap(Map<String, dynamic> dataMap) {
    name = AssertUtils.extractValue(dataMap, 'name');
    body = AssertUtils.extractValue(dataMap, 'body');
    icon = AssertUtils.extractValue(dataMap, 'icon');

    return this;
  }

  @override
  Map<String, dynamic> toMap() {
    return {'name': name, 'icon': icon, 'body': body};
  }

  @override
  String toString() {
    return toMap().toString();
  }

  @override
  void validate() {
    assert(!AssertUtils.isNullOrEmptyOrInvalid(name, String));
    assert(!AssertUtils.isNullOrEmptyOrInvalid(body, String));
    assert(!AssertUtils.isNullOrEmptyOrInvalid(icon, String));
  }
}
