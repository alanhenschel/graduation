#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
#define N 10
#define T 13

int limites_superior[T]={680,360,360,200,200,200,200,200,200,120,120,120,120};
int limites_inferior[T]={0,0,0,60,60,60,60,60,60,40,40,55,55};

float a[T]={0.00028,0.00056,0.00056,0.00324,0.00324,0.00324,0.00324,0.00324,0.00324,0.00284,0.00284,0.00284,0.00284};// vetor do coeficiente a
float b[T]={8.10,8.10,8.10,7.74,7.74,7.74,7.74,7.74,7.74,8.60,8.60,8.60,8.60};// vetor do coeficiente b
float c[T]={550,309,307,240,240,240,240,240,240,126,126,126,126};// vetor do coeficiente c


void gerapopulacao (float vet[][T])
{
    int x;
    //j itera sobre a solução
    //i itera na população
    //int limites_superior[T]={680,360,360,200,200,200,200,200,200,120,120,120,120};
    //int limites_inferior[T]={0,0,0,60,60,60,60,60,60,40,40,55,55};
    int i,j;

    //****Por que zerar se já vai setar para outro valor?
    for(i=0;i<N;i++)// caminha na população de tamanho 10
    {
        for(j=0;j<T;j++) //caminha na solução de tamanho 13
        {
            vet[i][j]=0.0;
        }
    }

    for(i=0;i<N;i++)// caminha na população de tamanho 10
    {
        for(j=0;j<T;j++) //caminha na solução de tamanho 13
        {
            vet[i][j] = ((float)rand()/RAND_MAX)*(limites_superior[j]-limites_inferior[j]) + limites_inferior[j];
            printf("matriz [%d] [%d]=%f\n",i,j,vet[i][j]);
        }
    }
}
//esta parte gera um valor entre zero e um ((float)rand()/RAND_MAX)
//pega a faixa de valores a serem amostrados (maximos[j]-minimos[j])
void calculaf (float vet[][T], float *f)
{
    int j,i,x;
    //float a[T]={0.00028,0.00056,0.00056,0.00324,0.00324,0.00324,0.00324,0.00324,0.00324,0.00284,0.00284,0.00284,0.00284};// vetor do coeficiente a
    //float b[T]={8.10,8.10,8.10,7.74,7.74,7.74,7.74,7.74,7.74,8.60,8.60,8.60,8.60};// vetor do coeficiente b
    //float c[T]={550,309,307,240,240,240,240,240,240,126,126,126,126};// vetor do coeficiente c
    for(i=0;i<N;i++) // caminha na população de tamanho 10
    {
        //***Precisa zerar para cada nova solução senão vai ficar acumulando com os valores anteriores
        f[i] = 0.0f;
        for(j=0;j<T;j++) //caminha na solução de tamanho 13
        {
            f[i]=f[i]+((a[j]*pow(vet[i][j],2))+(b[j]*vet[i][j])+c[j]);// aqui precisa considerar um vetor, pois temos um custo para cada solucao
        }
    }


}

float calculaf_solucao (float sol[T])
{
    int j,i,x;
    //float a[T]={0.00028,0.00056,0.00056,0.00324,0.00324,0.00324,0.00324,0.00324,0.00324,0.00284,0.00284,0.00284,0.00284};// vetor do coeficiente a
    //float b[T]={8.10,8.10,8.10,7.74,7.74,7.74,7.74,7.74,7.74,8.60,8.60,8.60,8.60};// vetor do coeficiente b
    //float c[T]={550,309,307,240,240,240,240,240,240,126,126,126,126};// vetor do coeficiente c

        float f = 0.0f;
        for(j=0;j<T;j++) //caminha na solução de tamanho 13
        {
            f=f+((a[j]*pow(sol[j],2))+(b[j]*sol[j])+c[j]);// aqui precisa considerar um vetor, pois temos um custo para cada solucao
        }
 }

void mutacao(float vet[][T], float *individuo, int i)// é o indivíduo da população (pai) que está sofrendo a mutação
{
    int j, indice1, indice2, indice3;
    float f=0.8;// individuo gerado
    // for(i=1;i<N;i++)
    indice1 = rand()%N;

    do{
        indice2 = rand()%N;
    }while(indice1 == indice2);

    do{
        indice3 = rand()%N;
    }while((indice1 == indice3)||(indice2 == indice3));

    //{
        for(j=0;j<T;j++)
        {
          //***Não é essa a fórmula da mutação, já conversamos sobre isso
          //individuo[i]=vet[rand()%N][j]+f*(vet[i+1][j]-vet[i+2][j]);
          individuo[j]=vet[indice1][j]+f*(vet[indice2][j]-vet[indice3][j]);
          //Reparacao..
          if(individuo[j] < limites_inferior[j])
            individuo[j] = limites_inferior[j];
          if(individuo[j] > limites_superior[j])
            individuo[j] = limites_superior[j];
        }
    //}
}
void cruzamento(float *individuo,float vet[][T], int i) // é o indivíduo da população (pai) que está sofrendo o cruzamento
{
    int j;
    float vetdescendente[N][T];
    float r,cr,d;
    cr=0.8;
    d=rand()%T;// de 0 a T-1 e não N
    // for(i=0;i<N;i++) // caminha na população de tamanho 10
    //{
        for(j=0;j<T;j++) //caminha na solução de tamanho 13
        {
            r=rand()%1;
            if(r<=cr || j==d)
            {
                vet[i][j]=individuo[j];
            }
        }
   // }
//     for(i=0;i<N;i++) // caminha na população de tamanho 10
//    {
//        for(j=0;j<T;j++)
//        {
//            printf("o vetor descendente[%d][%d]:%f\n",i,j,vetdescendente[i][j]);
//        }
//    }
}
int main()
{
    float vet[N][T],vetpai[N][T];
    float *c1,*c2,*u;
    int i,j,k=2,l;
    c1=malloc(N*sizeof(float));
    c2=malloc(N*sizeof(float));
    u=malloc(N*sizeof(float));
    for(i=0;i<N;i++)// caminha na população de tamanho 10
    {
        c1[i]=0.0;
        c2[i]=0.0;
        u[i]=0.0;
    }
    gerapopulacao(vet);
    calculaf(vet,c1); // calculo do primeiro fit
   // for(j=0;j<N;j++)
    //{
    //    printf("custo[%d]:%f\n",j,custos[j]);
    //}
    //for(m=0;m<N;m++)
    //{
      //  printf("mutacao[%d]:%f\n",m,u[m]);
    //}
      for(l=0;l<k;l++)
    {

        for(i=0;i<N;i++)
        {
            mutacao(vet,u, i);
            cruzamento(u,vet, i);
            float fFilho = calculaf_solucao(u);
            if(fFilho<c1[i])
                {
                    for(int pos = 0; pos < T; pos++)
                    {
                        vet[i][pos]=u[pos];
                    }
                    c1[i] = fFilho;
                }
        }


    }
     for(i=0;i<N;i++)
        {
               printf("\nresultado[%d] fitness: %f - sol =",i,c1[i]);
               for(j=0;j<T;j++)
               {
                    printf(" %f",vet[i][j]);
               }
               printf("\n");
        }
    return 0;
}
