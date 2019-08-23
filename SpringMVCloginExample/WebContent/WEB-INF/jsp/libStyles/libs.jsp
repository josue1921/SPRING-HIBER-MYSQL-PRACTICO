<spring:url value="/resources/css/all.css" var="all" />
<spring:url value="/resources/css/style.css" var="style" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootsTrapMin" />
<spring:url value="/resources/js/bootstrap.bundle.min.js" var="bootStrapBundle" />
<spring:url value="/resources/js/jquery.slim.min.js" var="jQuery" />

<link href="${all}" rel="stylesheet">
<link href="${style}" rel="stylesheet">
<link href="${bootsTrapMin}" rel="stylesheet">
<script src="${bootStrapBundle}"></script>
<script src="${jQuery}"></script>