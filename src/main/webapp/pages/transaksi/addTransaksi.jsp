<%-- 
    Document   : addTransaksi
    Created on : 05-Oct-2017, 14:25:38
    Author     : LENOVO
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Transaksi</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/transaksi/pinjam" method="post">
            <div>
                <label for="bukuId">Pili Buku</label>
                <select name="bukuId" id="bukuId">
                    <c:forEach items="${listBuku}" var="b">
                        <option value="${b.id}">${b.judulBuku} (${b.jumlahBuku})</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="pengunjungId">Pilih Pengunjung</label>
                <select name="pengunjungId" id="pengunjungId">
                    <c:forEach items="${listPengunjung}" var="p">
                        <option value="${p.id}">${p.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
