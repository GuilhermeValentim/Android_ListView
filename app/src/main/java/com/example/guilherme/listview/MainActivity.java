package com.example.guilherme.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** PRIMEIRO DE TUDO: Você deve colocar no seu layout o ListView e colocar um ID.
     * Depois disso, você deve coloca-lo como atributo da classe*/
    private ListView id_listView;


    /** Após isso, declare um array de String e coloque alguns itens nele. Coloquei apenas 10 itens apenas para exemplificar.*/
    private String itens[] = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Faça o findViewById do ListView que você colocou no Layout*/
        id_listView = (ListView) findViewById(R.id.id_listView);

        /** Agora, você deve instanciar a clase ArrayAdapter.
         * Os parâmetros que ele precisa é: 1º -> O contexto (nesse caso é o MainActivity.this
                                           *2º -> O tipo de lista que você quer utilizar. Há vários tipos de listas, eu costumo utilizar
                                                  * o simple_list_item_1.
                                           *3º -> O tipo de texto que o ListView irá utilizar.
                                           *4º -> A lista em si (Array que você criou).  */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                                                                android.R.layout.simple_list_item_1,
                                                                android.R.id.text1,
                                                                itens);

        /** Vamos setar o ListView no ArrayAdapter. */
        id_listView.setAdapter(adapter);

        /** PRONTO! Apenas com essas linhas de código, você consegue utilizar o ListView em qualquer projeto Android :D */


                                                                /** BÔNUS */
        /** Para você manusear os itens da ListView, você irá precisar adicionar um Listener, onde ele vai escutar cada item e fazer o que você
         * queira fazer.*/
        id_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /** Neste exemplo, eu quis pegar o valor do item que o usuário pressionou.
                 * Portanto, eu declarei uma variável String onde irei pegar a posição de cada item e transforma-lo em String.*/

                /** Utilizei este replace para na hora de exibir, não repetir o mesmo nome do item. Ele irá colocar vazio ao invés da
                 * palavra "Item"*/

                     /**VARIÁVEL      ListView    Posição de cada item (i) em String    Replace para trocar "Item" por vazio.*/
                String valorClicado = id_listView.getItemAtPosition(i).toString().replace("Item", "");

                /** Agora, faço um Toast para exibir a mensagem*/
                Toast.makeText(MainActivity.this, "Você clicou no item: " + valorClicado, Toast.LENGTH_SHORT).show();
            }
        });
                                                        /** Simples, não? :) */

    }
}
