<%-- 
    Document   : listTransaksi
    Created on : 05-Oct-2017, 17:11:40
    Author     : LENOVO
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="2" align="center">
            <thead>
                <tr align="center">
                    <td>NO</td>
                    <td>Nama Pengunjung</td>
                    <td>Kode Buku</td>
                    <td>Nama Buku</td>
                    <td>Tanggal Pinjam</td>
                    <td>Aksi</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listTransaksi}" var="t" varStatus="idx">
                <tr>
                    <td>${idx.count}</td>
                    <td>${t.pengunjung.nama}</td>
                    <td>${t.buku.id}</td>
                    <td>${t.buku.judulBuku}</td>
                    <td>${t.tanggalPinjam}</td>
                    <td>
                        <c:if test="${t.tanggalKembali != null}">
                            <c:out value="'Sudah dikembalikan'"/>
                        </c:if>
                        <c:if test="${t.tanggalKembali == null}">
                            <a href="${pageContext.servletContext.contextPath}/transaksi/kembalikan?kode=${t.id}">Kembalikan</a>
                        </c:if>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
