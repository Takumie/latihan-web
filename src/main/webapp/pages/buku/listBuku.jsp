<%-- 
    Document   : listBuku
    Created on : 05-Oct-2017, 09:38:08
    Author     : LENOVO
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Buku</title>
    </head>
    <body>
        <table border="2" align="center">
            <thead>
                <tr align="center">
                    <td>NO</td>
                    <td>Judul Buku</td>
                    <td>Tahun Buku</td>
                    <td>Jumlah Buku</td>
                    <td>Nama Pengarang</td>
                    <td>Aksi</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listBuku}" var="sebuahBuku" varStatus="index">
                <tr align="center">
                    <td>${index.count}</td>
                    <td>${sebuahBuku.judulBuku}</td>
                    <td>${sebuahBuku.tahunTerbit}</td>
                    <td>${sebuahBuku.jumlahBuku}</td>
                    <td>${sebuahBuku.pengarang}</td>
                    <td></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
