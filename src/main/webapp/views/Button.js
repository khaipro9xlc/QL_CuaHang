const btnList = document.querySelector('.btn');
btnList.forEach(btn1 => {
    btn1.addEventListener('click', () => {
        document.querySelector('.special')?.classList.remove('special')
        btn1.classList.add('special')
    });
});
