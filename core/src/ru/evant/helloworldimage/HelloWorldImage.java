package ru.evant.helloworldimage;

// Самообразование #1
// Java Game Development with LibGDX, 2nd Edition

/*
Наш первый проект состоит из двух классов.
Первый класс, называется HelloWorldImage,
использует функциональные возможности класса LibGDX с именем Game,
расширяя его.
 */

/*
	Класс HelloWorldImage содержит два объекта: Texture и SpriteBatch.

	Texture - это объект в котором хранятся данные, относящиеся к изображению:
	размеры (ширина и высота) изображения и цвет каждого пикселя.

	SpriteBatch - это объект, который рисует изображения на экране.

	Класс HelloWorldImage также содержит два метода: create и render.

	Метод create инициализирует объекты Texture и SpriteBatch.
	В частности, объект Texture требует файл изображения, из которого он будет получать данные изображения.
	Для этого вы создаете FileHandle - объект LibGDX, который используется для доступа к файлам, хранящимся на компьютере.
	Класс Gdx содержит много полезных статических объектов и методов (аналогично классу Java Math);
	здесь вы используете метод с именем internal для создания FileHandle объекта, который будет использоваться объектом текстуры(Texture).

	Внутренний метод будет искать файл в каталоге проекта, то же место, где хранятся скомпилированные файлы классов.
	После завершения метода создания метод рендеринга(render) будет вызван LibGDX примерно 60 раз в секунду
	(поскольку это то, что класс Game делает по умолчанию).
	Этот метод содержит пару вызовов статических методов:
	один для выбора определенного цвета фона (значения в этом примере соответствуют белому цвету),
	а другой - использовать этот цвет для очистки окна.
	После этого объект SpriteBatch используется для позиционирования и рисования текстуры в окне.

	Поскольку ни текстура, ни координаты в этом примере не меняются, тот факт,
	что метод рендеринга вызывается неоднократно, здесь не имеет значения.
	Однако, если вы должны периодически менять изображение, вы можете сгенерировать анимацию;
	если бы вы постепенно меняли координаты, вы могли бы имитировать движение.
 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloWorldImage extends Game {

	private Texture texture;
	private SpriteBatch batch;

	
	@Override
	public void create () {
		FileHandle worldFile = Gdx.files.internal("world.png");
		texture = new Texture(worldFile);
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(texture, 120, 40, 400,400);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}
}
