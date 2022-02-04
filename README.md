<b>Сценарий 1.</b> </br>
Конвертер арабских чисел в римские на промежутке от 1 до 50 включительно.</br>
Пользователь делает вызов GET http://84.201.166.40:8080/roman/{arabian_value} и получает ответ, конвертирующий арабское число в римское.
</br>
Request: GET http://84.201.166.40:8080/roman/2</br>
Response Code: HTTP 200 OK</br>
Response Body:</br>
{</br>
"code": 200,</br>
"value": "II"</br>
}</br>
<b>Сценарий 2. </b></br>
Возможность добавить владельца к будущим результатам конвертации из сценария 1.</br>
POST http://84.201.166.40:8080/roman/owner</br>
RequestBody:</br>

{</br>
"firstName": "Anakin",</br>
"lastName": "Skywalker"</br>
}</br>
Response Code: HTTP 201 Created</br>
Response Body: Empty</br>

Теперь для последующих любых вызовов сценария 1 пользователь должен получать ответ, содержащий поле owner.</br>
Request: GET http://84.201.166.40:8080/roman/11</br>
Response Code: HTTP 200 OK</br>
Response Body:</br>

{</br>
"code": 200,</br>
"value": "XI",</br>
"owner": "Anakin Skywalker"</br>
}</br>