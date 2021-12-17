(function () {
    document.onmousemove = (e) => {
        let compass = document.getElementById('compass');
        compassClient = compass.getBoundingClientRect()

        let dx = compassClient.left + 30 - e.clientX;
        let dy = compassClient.top + 30 - e.clientY;
        let tan = dy / dx;
        let angle;
        if (dx >= 0) {
            angle = Math.atan(tan) * 57.2957795 + 180;
        }
        else {
            angle = Math.atan(tan) * 57.2957795;
        }
        document.getElementById('compass').style.transform = `rotate(${angle}deg)`;

    }


    document.getElementById('article_redirect').onclick = () => {
        document.getElementById('article_redirect').style = "top:120vh";
        let navBoxes = document.querySelectorAll(".navBox");
        for (let i = 0; i < navBoxes.length; i++) {
            if (navBoxes[i] != document.getElementById('article_redirect').querySelector('.navBox')) {
                navBoxes[i].style = "z-index:998;";
            }
        }
        setTimeout(() => {
            window.location.href = "/book";

        }, 1000);
    }



    let enableMove = true;
    document.addEventListener('mousewheel', function (event) {
        if (!enableMove) {
            event.preventDefault();
            event.stopPropagation();
            return;
        }
        if (document.documentElement.scrollTop < 10 && event.wheelDelta < 0) {
            event.preventDefault();
            event.stopPropagation();
            window.location.href = "#page2";
            enableMove = false;
            setTimeout(() => {
                enableMove = true;
            }, 600);

        }

        if (Math.abs(document.documentElement.scrollTop - window.innerHeight) <= 10 && event.wheelDelta > 0) {
            event.preventDefault();
            event.stopPropagation();
            window.location.href = "#page1";
            enableMove = false;
            setTimeout(() => {
                enableMove = true;
            }, 600);
            return;
        }
        if (event.wheelDelta > 0 && document.documentElement.scrollTop - window.innerHeight > 0 && document.documentElement.scrollTop - window.innerHeight < event.wheelDelta) {
            console.log('aa');
            enableMove = false;
            setTimeout(() => {
                enableMove = true;
            }, 600);
            document.documentElement.scrollTop = window.innerHeight;
            event.preventDefault();
            event.stopPropagation();
            return;
        }
    }, { passive: false })



})();