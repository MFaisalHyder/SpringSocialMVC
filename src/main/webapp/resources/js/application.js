function facebookForm() {
    document.fbForm.target = 'fbForm';
    popUpWindow = window.open('', 'fbForm', 'status=1,width=550,height=500,toolbar=0');
    document.fbForm.submit();
    popUpWindow.moveTo(20, 20);

    var temp = popUpWindow.document;
    temp.write('<html><head>');
    temp.write('<title> Login to Facebook! </title>');
    temp.write('<link rel="stylesheet" href="resources/css/application.css"/> </head>');
    temp.write('<body class="popup_background"><h3> Please wait...</h3>');
    temp.write('</body></html>');
    temp.close();
}

function fetchData() {

    var request = new XMLHttpRequest();

    request.open('GET', '/SpringSocialMVC/getData', true);
    request.send();
    request.onreadystatechange = processRequest;

    function processRequest() {
        if (request.status == 200 && request.readyState == 4) {
            window.close();
        }
    }
}