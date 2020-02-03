package com.bartug.survivorbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

import java.util.Random;

public class surivorbirds extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture bird; //SpaceShip
	Texture bee1;
	Texture bee2; //Alliens
	Texture bee3;

	float birdX=0;
	float birdY=0;
	int gameState=0;
	float velocity=0;
	float gravity=0.3f;
	float enemyVelocity=5;
	Random random;
	int score=0;
	int scoreEnemy;
	BitmapFont font;
	BitmapFont font2;

	Circle birdCircle;
	ShapeRenderer shapeRenderer;

	int numberOfEnemies =4;
	float[] enemyX=new float[numberOfEnemies];
	float[] enemyOffset = new float[numberOfEnemies];
	float[] EnemyOffset2 = new float[numberOfEnemies];
	float[] EnemyOffset3 = new float[numberOfEnemies];

	float distance=0;
	Circle[] enemyCircles;
	Circle[] enemyCircles2;
	Circle[] enemyCircles3;

	@Override
	public void create () {
		batch=new SpriteBatch();
		background=new Texture("sky1.png");
		bird=new Texture("dino-spaceship-flying-game-character.png");
		bee1=new Texture("ufo_enemy_game_character.png");
		bee2=new Texture("ufo_enemy_game_character.png");
		bee3=new Texture("ufo_enemy_game_character.png");  //DRAW UFOS

		distance=Gdx.graphics.getWidth()/2;
		random = new Random();

		birdX=Gdx.graphics.getWidth()/2-bird.getHeight()/2;
		birdY=Gdx.graphics.getHeight()/3;
		//shapeRenderer=new ShapeRenderer();

		birdCircle=new Circle();
		enemyCircles=new Circle[numberOfEnemies];
		enemyCircles2=new Circle[numberOfEnemies];
		enemyCircles3=new Circle[numberOfEnemies];
		font=new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(4);

		font2=new BitmapFont();
		font2.setColor(Color.WHITE);
		font2.getData().setScale(6);

		for(int i=0;i<numberOfEnemies;i++){

			enemyOffset[i]=(random.nextFloat())*(Gdx.graphics.getHeight()-200);
			EnemyOffset2[i]=(random.nextFloat())*(Gdx.graphics.getHeight()-200);
			EnemyOffset3[i]=(random.nextFloat())*(Gdx.graphics.getHeight()-200);

			enemyX[i]=Gdx.graphics.getWidth()-bee1.getWidth()/2 + i *distance;
			enemyCircles[i]=new Circle();
			enemyCircles2[i]=new Circle();
			enemyCircles3[i]=new Circle();
		}
	}

	@Override
	public void render () { //Game is running
		batch.begin();
		batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		if(Gdx.input.justTouched()){

				velocity=-Gdx.graphics.getHeight()*0.02f; //velocity is down , this idea work for me

		}
		if(gameState==1)
		{
			if(enemyX[scoreEnemy]<Gdx.graphics.getWidth()/2-bird.getHeight()/2)
			{
				score++;
				if (scoreEnemy<numberOfEnemies-1){
					scoreEnemy++;
				}
				else {scoreEnemy=0;}
			}
			if (birdY >=Gdx.graphics.getHeight() ){

				gameState = 2;

			}
				if (birdY>0)
				{
					velocity=velocity+0.5f;
				}
				else{
					gameState=2;
					}
		 	for(int i=0;i<numberOfEnemies;i++) {
		 		if(enemyX[i]<Gdx.graphics.getWidth() / 15){
		 			enemyX[i]=enemyX[i]+numberOfEnemies*distance;

					enemyOffset[i]=(random.nextFloat())*(Gdx.graphics.getHeight()-200);
					EnemyOffset2[i]=(random.nextFloat())*(Gdx.graphics.getHeight()-200);
					EnemyOffset3[i]=(random.nextFloat())*(Gdx.graphics.getHeight()-200); //Thats not sense
				}else {
					enemyX[i] = enemyX[i] - enemyVelocity;
				}
				if (!(Gdx.graphics.getHeight()/2 + enemyOffset[i] > Gdx.graphics.getHeight()))
					batch.draw(bee1,enemyX[i],Gdx.graphics.getHeight()/2 + enemyOffset[i],
							Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()/10);
				else
					enemyOffset[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

				if (!(Gdx.graphics.getHeight()/2 + EnemyOffset2[i] > Gdx.graphics.getHeight()))
					batch.draw(bee1,enemyX[i],Gdx.graphics.getHeight()/2 + EnemyOffset2[i],
							Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()/10);
				else
					EnemyOffset2[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

				if (!(Gdx.graphics.getHeight()/2 + EnemyOffset3[i] > Gdx.graphics.getHeight()))
					batch.draw(bee1,enemyX[i],Gdx.graphics.getHeight()/2 + EnemyOffset3[i],
							Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()/10);
				else
					EnemyOffset3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);



				enemyCircles[i] = new Circle(enemyX[i] + Gdx.graphics.getWidth() / 30,  Gdx.graphics.getHeight()/2 + enemyOffset[i] + Gdx.graphics.getHeight() / 20,Gdx.graphics.getWidth() / 30);
				enemyCircles2[i] = new Circle(enemyX[i] + Gdx.graphics.getWidth() / 30,  Gdx.graphics.getHeight()/2 + EnemyOffset2[i] + Gdx.graphics.getHeight() / 20,Gdx.graphics.getWidth() / 30);
				enemyCircles3[i] = new Circle(enemyX[i] + Gdx.graphics.getWidth() / 30,  Gdx.graphics.getHeight()/2 + EnemyOffset3[i] + Gdx.graphics.getHeight() / 20,Gdx.graphics.getWidth() / 30);


			}



			if(birdY>0 || velocity<0)
			{
				velocity = velocity + gravity;
				birdY = birdY - velocity;
			}

		}
		else if(gameState==0)
			{
			if(Gdx.input.justTouched())
				{
					gameState=1;
				}
			}
		else if(gameState==2){
			font2.draw(batch,"Game Over! Tap To Play Again!",100,Gdx.graphics.getHeight()/2);
			if(Gdx.input.justTouched()){
				gameState=1;
				birdY=Gdx.graphics.getHeight()/3;

				for(int i=0;i<numberOfEnemies;i++) {
					enemyOffset[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
					EnemyOffset2[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
					EnemyOffset3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

					enemyX[i] = Gdx.graphics.getWidth() - bee1.getWidth() / 2 + i * distance;

						enemyCircles[i]=new Circle();
						enemyCircles2[i]=new Circle();
						enemyCircles3[i]=new Circle();

				}
					velocity=0;
					scoreEnemy=0;
					score=0;

			 }
		}


		batch.draw(bird,birdX,birdY,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()/10);
		font.draw(batch,String.valueOf(score),100,200);
		batch.end();
		birdCircle.set(birdX+Gdx.graphics.getWidth()/40,birdY+Gdx.graphics.getHeight()/40,Gdx.graphics.getWidth()/40);
		//shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		//shapeRenderer.setColor(Color.BLACK);
		//shapeRenderer.circle(birdCircle.x,birdCircle.y,birdCircle.radius);

		for(int i=0;i<numberOfEnemies;i++){
		//	shapeRenderer.circle(enemyX[i]+Gdx.graphics.getWidth() / 30,Gdx.graphics.getHeight()/2+enemyOffset[i]+Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth() / 30);
		//	shapeRenderer.circle(enemyX[i]+Gdx.graphics.getWidth() / 30,Gdx.graphics.getHeight()/2+EnemyOffset2[i]+Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth() / 30);
		//	shapeRenderer.circle(enemyX[i]+Gdx.graphics.getWidth() / 30,Gdx.graphics.getHeight()/2+EnemyOffset3[i]+Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth() / 30);
			if(Intersector.overlaps(birdCircle,enemyCircles[i])||Intersector.overlaps(birdCircle,enemyCircles2[i])||Intersector.overlaps(birdCircle,enemyCircles3[i])){
				gameState=2;
			}
		}
		//shapeRenderer.end();
	}


	@Override
	public void dispose () {

	}
}
