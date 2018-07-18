package Servlets.KultaVendas;
//package KultaVendas;
//
//import EstruturasDeDados8.Lista8;
//import EstruturasDeDados8.Par8;
//import EstruturasDeDados8.TabelaHash8;
//import FluxoDeArquivos.FluxoBeans;
//import Graficos.GraficoDeLinha;
//import Kulta.KultaEnumeracoes.COR;
//import Kulta.KultaEnumeracoes.NOME;
//import Kulta.KultaEnumeracoes.TAMANHO;
//import java.util.Arrays;
//import java.util.Comparator;
//import matematica.Frequencia;
//import matematica.RegressaoLinearSimples;
//
///**
// *
// * @author david
// */
//public class HistoricoDeVendas{
//    Lista8<Venda> vendas = new Lista8<Venda>();
//    FluxoBeans<Lista8<Venda>> arquivo = new FluxoBeans<Lista8<Venda>>("historico");
//    Lista8<NOME> listaDeNomesUnicos;// = new Lista8<>(Arrays.asList(NOME.values()));
//    Lista8<TAMANHO> listaDeTamanhosUnicos = new Lista8<TAMANHO>(Arrays.asList(TAMANHO.values()));
//    Lista8<COR> listaDeCoresUnicas = new Lista8<COR>(Arrays.asList(COR.values()));
//
//    public HistoricoDeVendas(){
//        listaDeNomesUnicos = new Lista8<NOME>(Arrays.asList(NOME.auroracolorido, NOME.basicrosa, NOME.belasalmao, NOME.costaocolorido, NOME.florazul, NOME.jasminebranco,
//                NOME.magnificabranco, NOME.princesarosa, NOME.rainharosa
//        ));
//    }
//
//    public void adicionaVenda(NOME nomeDoProduto, String data, Integer unidadesvendidas, Double valordaunidade, COR cor, TAMANHO tamanho){
//        //System.out.println( nomeDoProduto + " " + data + " " + unidadesvendidas + " " + valordaunidade + " " + cor + " "+ tamanho );
//        switch(nomeDoProduto){
//            case combo10princesarosa:
//                nomeDoProduto = NOME.princesarosa;
//                unidadesvendidas *= 10;
//                break;
//            case combo10magnificabranco:
//                nomeDoProduto = NOME.magnificabranco;
//                unidadesvendidas *= 10;
//                break;
//            case combo2auroracolorido:
//                nomeDoProduto = NOME.auroracolorido;
//                unidadesvendidas *= 2;
//                break;
//            case combo2florazul:
//                nomeDoProduto = NOME.florazul;
//                unidadesvendidas *= 2;
//                break;
//            case combo2magnificabranco:
//                nomeDoProduto = NOME.magnificabranco;
//                unidadesvendidas *= 2;
//                break;
//            case combo2rainharosa:
//                nomeDoProduto = NOME.rainharosa;
//                unidadesvendidas *= 2;
//                break;
//            case combo4auroracolorido:
//                nomeDoProduto = NOME.auroracolorido;
//                unidadesvendidas *= 4;
//                break;
//            case combo4magnificabranco:
//                nomeDoProduto = NOME.magnificabranco;
//                unidadesvendidas *= 4;
//                break;
//            default:
//                break;
//        }
//        //System.out.println( nomeDoProduto + " " + data + " " + unidadesvendidas + " " + valordaunidade + " " + cor + " "+ tamanho );
//        for(int i = 0; i<unidadesvendidas; i++)
//            vendas.adiciona(Venda.setTudo(nomeDoProduto, data, 1, valordaunidade, cor, tamanho));
//    }
//
//    public void salvaNoArquivo(){
//        arquivo.escreve(vendas);
//    }
//
//    public void apagaArquivo(){
//        arquivo.apaga();
//    }
//
//    public void console(String texto){
//        System.out.println(texto);
//    }
//
//    public void ordenaPorNome(){
//        vendas.ordena();
//    }
//
//    public void ordenaPorData(){
//        vendas.ordena(new comparadorPorData());
//    }
//
//    public void ordenaPorMes(Lista8<Par8<Double, Double>> listaDeMeses){
//        listaDeMeses.ordena(new comparadorPorMes());
//    }
//
//    private static class comparadorPorMes implements Comparator<Par8<Double, Double>>{
//        @Override
//        public int compare(Par8<Double, Double> p1, Par8<Double, Double> p2){
//            return p1.getX().compareTo(p2.getX());
//        }
//    }
//
//    private static class comparadorPorData implements Comparator<Venda>{
//        @Override
//        public int compare(Venda venda1, Venda venda2){
//            return venda1.getData().compareTo(venda2.getData());
//        }
//    }
//
//    /*
//     * FILTROS DA LISTA
//     */
//    public Lista8<Venda> sublistaVendasParaUmaCor(COR cor, Lista8<Venda> listaDeOrigem){
//        return listaDeOrigem.sublista(venda -> venda.getCor().equals(cor));
//    }
//
//    public Lista8<Venda> sublistaVendasParaUmTamanho(TAMANHO tamanho, Lista8<Venda> listaDeOrigem){
//        return listaDeOrigem.sublista(venda -> venda.getTamanho().equals(tamanho));
//    }
//
//    public Lista8<Venda> sublistaVendasParaUmNome(NOME nome, Lista8<Venda> listaDeOrigem){
//        return listaDeOrigem.sublista(venda -> venda.getNome().equals(nome));
//    }
//
//    public Lista8<Venda> sublistaVendasParaUmAno(int ano, Lista8<Venda> listaDeOrigem){
//        return listaDeOrigem.sublista(venda -> venda.getData().ano()==ano);
//    }
//
//    public Lista8<Venda> sublistaVendasParaUmMes(int ano, int mes, Lista8<Venda> listaDeOrigem){
//        return listaDeOrigem.sublista(venda
//                -> (venda.getData().ano()==ano&&venda.getData().mes()==mes)
//        );
//    }
//
//    /*
//     * LISTAS PARA CÁCULOS DE FREQUENCIA obs:: Recbem uma lista já filtrada, ou
//     * não, para poderem extrair as informações relevantes.
//     */
//    public Lista8<TAMANHO> listaDeTamanhos(Lista8<Venda> vendas){
//        Lista8<TAMANHO> listaDeTamanhos = new Lista8<>();
//        vendas.paraCada(venda -> listaDeTamanhos.adiciona(venda.getTamanho()));
//        return listaDeTamanhos;
//    }
//
//    public Lista8<COR> listaDeCores(Lista8<Venda> vendas){
//        Lista8<COR> listaDeTamanhos = new Lista8<>();
//        vendas.paraCada(venda -> listaDeTamanhos.adiciona(venda.getCor()));
//        return listaDeTamanhos;
//    }
//
//    public Lista8<NOME> listaDeNomes(Lista8<Venda> vendas){
//        Lista8<NOME> listaDeTamanhos = new Lista8<>();
//        vendas.paraCada(venda -> listaDeTamanhos.adiciona(venda.getNome()));
//        return listaDeTamanhos;
//    }
//
//    /*
//     * RELATORIOS DE FREQUENCIAS
//     */
//    public void relatorioFreqAbsolutaNomes(Lista8<Venda> listaFiltrada){
//        Frequencia<NOME> f = new Frequencia<>();
//        for(NOME nomeUnico : listaDeNomesUnicos){
//            Double frequenciaAbsoluta = f.frequenciaAbsoluta(listaDeNomes(listaFiltrada), nomeUnico);
//            System.out.printf("%-17s", nomeUnico+":"+String.format("%.0f", frequenciaAbsoluta));
//        }
//        System.out.println();
//    }
//
//    public void relatorioFreqAbsolutaCores(Lista8<Venda> listaFiltrada){
//        Frequencia<COR> f = new Frequencia<>();
//        for(COR corUnica : listaDeCoresUnicas){
//            Double frequenciaAbsoluta = f.frequenciaAbsoluta(listaDeCores(listaFiltrada), corUnica);
//            System.out.printf("%-17s", corUnica+":"+String.format("%.0f", frequenciaAbsoluta));
//        }
//        System.out.println();
//    }
//
//    public void relatorioFreqAbsolutaTamanhos(Lista8<Venda> listaFiltrada){
//        Frequencia<TAMANHO> f = new Frequencia<>();
//        for(TAMANHO tamanhoUnico : listaDeTamanhosUnicos){
//            Double frequenciaAbsoluta = f.frequenciaAbsoluta(listaDeTamanhos(listaFiltrada), tamanhoUnico);
//            System.out.printf("%-17s", tamanhoUnico+":"+String.format("%.0f", frequenciaAbsoluta));
//        }
//        System.out.println();
//    }
//
//    public void relatorioFreqPercentualNomes(Lista8<Venda> listaFiltrada){
//        Frequencia<NOME> f = new Frequencia<>();
//        for(NOME nomeUnico : listaDeNomesUnicos){
//            Double frequenciaPercentual = f.frequenciaPercentual(listaDeNomes(listaFiltrada), nomeUnico);
//            System.out.printf("%-17s", nomeUnico+":"+String.format("%.2f", frequenciaPercentual*100)+"%");
//        }
//        System.out.println();
//    }
//
//    public void relatorioFreqPercentualCores(Lista8<Venda> listaFiltrada){
//        Frequencia<COR> f = new Frequencia<>();
//        for(COR corUnica : listaDeCoresUnicas){
//            Double frequenciaPercentual = f.frequenciaPercentual(listaDeCores(listaFiltrada), corUnica);
//            System.out.printf("%-17s", corUnica+":"+String.format("%.2f", frequenciaPercentual*100)+"%");
//        }
//        System.out.println();
//    }
//
//    public void relatorioFreqPercentualTamanhos(Lista8<Venda> listaFiltrada){
//        Frequencia<TAMANHO> f = new Frequencia<>();
//        for(TAMANHO tamanhoUnico : listaDeTamanhosUnicos){
//            Double frequenciaPercentual = f.frequenciaPercentual(listaDeTamanhos(listaFiltrada), tamanhoUnico);
//            System.out.printf("%-17s", tamanhoUnico+":"+String.format("%.2f", frequenciaPercentual*100)+"%");
//        }
//        System.out.println();
//    }
//
//    /*
//     * GRÁFICOS
//     */
//    public void graficoMesQuantidadeVendas(int ano){
//        GraficoDeLinha<Integer, Integer> grafico = new GraficoDeLinha<>();
//        for(NOME nomeUnico : listaDeNomesUnicos){
//            TabelaHash8<Integer, Integer> parDataQuantidade = new TabelaHash8<>();
//            for(Venda venda : sublistaVendasParaUmNome(nomeUnico, sublistaVendasParaUmAno(ano, vendas))){
//                Integer valorAntigo = parDataQuantidade.adiciona(venda.getData().mes(), venda.getUnidadesvendidas());
//                if(valorAntigo!=null)
//                    parDataQuantidade.adiciona(venda.getData().mes(), venda.getUnidadesvendidas()+valorAntigo);
//            }
//            grafico.adicionaConjuntoDeDados(parDataQuantidade, nomeUnico.toString());
//        }
//        grafico.criaGrafico("Meses do ano de "+ano, "Unidades vendidas", "Vendas do ano de "+ano);
//    }
//
//    public void graficoMesQuantidadeVendasSeparados(int ano){
//        for(NOME nomeUnico : listaDeNomesUnicos){
//            TabelaHash8<Integer, Integer> parDataQuantidade = new TabelaHash8<>();
//            for(Venda venda : sublistaVendasParaUmNome(nomeUnico, sublistaVendasParaUmAno(ano, vendas))){
//                Integer valorAntigo = parDataQuantidade.adiciona(venda.getData().mes(), venda.getUnidadesvendidas());
//                if(valorAntigo!=null)
//                    parDataQuantidade.adiciona(venda.getData().mes(), venda.getUnidadesvendidas()+valorAntigo);
//            }
//            GraficoDeLinha<Integer, Integer> grafico = new GraficoDeLinha<>();
//            grafico.criaGrafico(parDataQuantidade, nomeUnico.toString(), "Meses do ano de "+ano, "Unidades vendidas", nomeUnico.toString());
//        }
//    }
//
//    public void graficoMesQuantidadeVendasRegredido(int ano){
//        final Lista8<Integer> meses = new Lista8(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
//        GraficoDeLinha<Integer, Double> grafico = new GraficoDeLinha<>();
//        RegressaoLinearSimples regressao;
//        TabelaHash8<Double, Double> parDataQuantidade = new TabelaHash8<>();
//        Lista8<Par8<Integer, Double>> pDQR = new Lista8<>();
//        for(NOME nome : listaDeNomesUnicos){
//            regressao = new RegressaoLinearSimples();
//            parDataQuantidade = new TabelaHash8<>();
//            pDQR = new Lista8<>();
//            for(Venda venda : sublistaVendasParaUmNome(nome, sublistaVendasParaUmAno(ano, vendas)))
//                parDataQuantidade.adicionaSomando(new Double(""+venda.getData().mes()), new Double(""+venda.getUnidadesvendidas()));
//            regressao.adicionaDados(parDataQuantidade);
//            for(Integer mes : meses)
//                pDQR.adiciona(new Par8<>(mes, regressao.projecaoParaValor(mes)));
//            pDQR.ordena();
//            grafico.adicionaConjuntoDeDados(pDQR, nome.toString());
//        }
//        grafico.criaGrafico("Meses do ano de "+ano, "Unidades vendidas", "(Regressão)Vendas do ano de "+ano);
//    }
//
//    public void quantidadeDeVendas(){
//        System.out.println("Total de vendas:"+vendas.tamanho());
//        System.out.println("Obs:: Combos são convertidos");
//    }
//
//    public void relatorioCompleto(){
//        System.out.println("Para todos os registros\n");
//        relatorioFreqAbsolutaCores(vendas);
//        relatorioFreqPercentualCores(vendas);
//        relatorioFreqAbsolutaNomes(vendas);
//        relatorioFreqPercentualNomes(vendas);
//        relatorioFreqAbsolutaTamanhos(vendas);
//        relatorioFreqPercentualTamanhos(vendas);
//        System.out.println();
//        System.out.println("Para o ano de 2016\n");
//        relatorioFreqAbsolutaCores(sublistaVendasParaUmAno(2016, vendas));
//        relatorioFreqPercentualCores(sublistaVendasParaUmAno(2016, vendas));
//        relatorioFreqAbsolutaNomes(sublistaVendasParaUmAno(2016, vendas));
//        relatorioFreqPercentualNomes(sublistaVendasParaUmAno(2016, vendas));
//        relatorioFreqAbsolutaTamanhos(sublistaVendasParaUmAno(2016, vendas));
//        relatorioFreqPercentualTamanhos(sublistaVendasParaUmAno(2016, vendas));
//        System.out.println();
//        System.out.println("Para o ano de 2017\n");
//        relatorioFreqAbsolutaCores(sublistaVendasParaUmAno(2017, vendas));
//        relatorioFreqPercentualCores(sublistaVendasParaUmAno(2017, vendas));
//        relatorioFreqAbsolutaNomes(sublistaVendasParaUmAno(2017, vendas));
//        relatorioFreqPercentualNomes(sublistaVendasParaUmAno(2017, vendas));
//        relatorioFreqAbsolutaTamanhos(sublistaVendasParaUmAno(2017, vendas));
//        relatorioFreqPercentualTamanhos(sublistaVendasParaUmAno(2017, vendas));
//        System.out.println();
//        quantidadeDeVendas();
//        graficoMesQuantidadeVendas(2016);
//        graficoMesQuantidadeVendasRegredido(2016);
//    }
//}
