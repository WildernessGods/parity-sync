package com.parity.paritysync.utils.parity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parity.paritysync.utils.parity.result.ResultCommon;
import com.parity.paritysync.utils.parity.result.ResultGetBlock;
import com.parity.paritysync.utils.parity.result.ResultGetTransactionReceipt;
import com.parity.paritysync.utils.parity.result.ResultGetTransactions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ParityRequest {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Logger logger = LoggerFactory.getLogger(ParityRequest.class);

    /**
     * Returns the number of most recent block.
     *
     * @return
     * @throws IOException
     */
    public static ResultCommon eth_blockNumber() throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_blockNumber");

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultCommon.class);
    }

    /**
     * Returns information about a block by block number.
     *
     * @param blockNumber
     * @return
     * @throws IOException
     */
    public static ResultGetBlock eth_getBlockByNumber(String blockNumber) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getBlockByNumber", new ArrayList<Object>() {{
            add(blockNumber);
            add(true);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultGetBlock.class);
    }

    /**
     * Returns information about a block by hash.
     *
     * @param blockHash
     * @return
     * @throws IOException
     */
    public static ResultGetBlock eth_getBlockByHash(String blockHash) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getBlockByHash", new ArrayList<Object>() {{
            add(blockHash);
            add(true);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultGetBlock.class);
    }

    /**
     * Returns the current price per gas in wei.
     *
     * @return
     * @throws IOException
     */
    public static ResultCommon eth_gasPrice() throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_gasPrice");

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultCommon.class);
    }

    /**
     * Returns the balance of the account of given address
     *
     * @param address
     * @param status  HEX String - an integer block number
     *                String "earliest" for the earliest/genesis block
     *                String "latest" - for the latest mined block
     *                String "pending" - for the pending state/transactions
     * @return
     * @throws IOException
     */
    public static ResultCommon eth_getBalance(String address, String status) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getBalance", new ArrayList<Object>() {{
            add(address);
            add(status);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultCommon.class);
    }

    /**
     * Returns the number of transactions sent from an address
     *
     * @param address
     * @param status  HEX String - an integer block number
     *                String "earliest" for the earliest/genesis block
     *                String "latest" - for the latest mined block
     *                String "pending" - for the pending state/transactions
     * @return
     * @throws IOException
     */
    public static ResultCommon eth_getTransactionCount(String address, String status) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getTransactionCount", new ArrayList<Object>() {{
            add(address);
            add(status);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultCommon.class);
    }

    /**
     * Returns the number of transactions in a block from a block matching the given block hash.
     *
     * @param blockHash
     * @return
     * @throws IOException
     */
    public static ResultCommon eth_getBlockTransactionCountByHash(String blockHash) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getBlockTransactionCountByHash", new ArrayList<Object>() {{
            add(blockHash);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultCommon.class);
    }

    /**
     * Returns the number of transactions in a block matching the given block number.
     *
     * @param number
     * @return
     * @throws IOException
     */
    public static ResultCommon eth_getBlockTransactionCountByNumber(String number) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getBlockTransactionCountByNumber", new ArrayList<Object>() {{
            add(number);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultCommon.class);
    }

    /**
     * Returns the number of uncles in a block from a block matching the given block hash.
     *
     * @param blockHash
     * @return
     * @throws IOException
     */
    public static ResultCommon eth_getUncleCountByBlockHash(String blockHash) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getUncleCountByBlockHash", new ArrayList<Object>() {{
            add(blockHash);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultCommon.class);
    }

    /**
     * Returns the number of uncles in a block from a block matching the given block number.
     *
     * @param number
     * @return
     * @throws IOException
     */
    public static ResultCommon eth_getUncleCountByBlockNumber(String number) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getUncleCountByBlockNumber", new ArrayList<Object>() {{
            add(number);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultCommon.class);
    }

    /**
     * Returns the information about a transaction requested by transaction hash.
     *
     * @param transactionHash
     * @return
     * @throws IOException
     */
    public static ResultGetTransactions eth_getTransactionByHash(String transactionHash) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getTransactionByHash", new ArrayList<Object>() {{
            add(transactionHash);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultGetTransactions.class);
    }

    /**
     * Returns the information about a transaction requested by transaction hash.
     *
     * @param blockHash
     * @param transactionIndex
     * @return
     * @throws IOException
     */
    public static ResultGetTransactions eth_getTransactionByBlockHashAndIndex(String blockHash, String transactionIndex) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getTransactionByBlockHashAndIndex", new ArrayList<Object>() {{
            add(blockHash);
            add(transactionIndex);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultGetTransactions.class);
    }

    /**
     * Returns information about a transaction by block number and transaction index position.
     *
     * @param blockNumber
     * @param transactionIndex
     * @return
     * @throws IOException
     */
    public static ResultGetTransactions eth_getTransactionByBlockNumberAndIndex(String blockNumber, String transactionIndex) throws IOException {

        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getTransactionByBlockNumberAndIndex", new ArrayList<Object>() {{
            add(blockNumber);
            add(transactionIndex);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultGetTransactions.class);
    }

    /**
     * Returns information about a uncle of a block by hash and uncle index position.
     *
     * @param blockHash
     * @param index
     * @return
     * @throws IOException
     */
    public static ResultGetBlock eth_getUncleByBlockHashAndIndex(String blockHash, Integer index) throws IOException {
        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getUncleByBlockHashAndIndex", new ArrayList<Object>() {{
            add(blockHash);
            add("0x" + Integer.toHexString(index));
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultGetBlock.class);
    }

    /**
     * Returns information about a uncle of a block by number and uncle index position.
     *
     * @param blockNumber
     * @param index
     * @return
     * @throws IOException
     */
    public static ResultGetBlock eth_getUncleByBlockNumberAndIndex(String blockNumber, Integer index) throws IOException {
        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getUncleByBlockNumberAndIndex", new ArrayList<Object>() {{
            add(blockNumber);
            add("0x" + Integer.toHexString(index));
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultGetBlock.class);
    }

    /**
     * Returns the receipt of a transaction by transaction hash.
     *
     * @param transactionHash
     * @return
     * @throws IOException
     */
    public static ResultGetTransactionReceipt eth_getTransactionReceipt(String transactionHash) throws IOException {
        ParityParams parityParams = new ParityParams(1, "2.0", "eth_getTransactionReceipt", new ArrayList<Object>() {{
            add(transactionHash);
        }});

        return objectMapper.readValue(request(objectMapper.writeValueAsString(parityParams)), ResultGetTransactionReceipt.class);
    }

    private static String request(String content) {
        StringBuilder response = new StringBuilder();
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            URL realUrl = new URL("http://127.0.0.1:8545");
            // 打开和URL之间的连接  
            URLConnection conn = realUrl.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
            // 设置请求属性  
            httpUrlConnection.setRequestProperty("Content-Type", "application/json");
            httpUrlConnection.setRequestProperty("x-adviewrtb-version", "2.1");
            // 发送POST请求必须设置如下两行  
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流  
            out = new PrintWriter(httpUrlConnection.getOutputStream());
            // 发送请求参数  
            out.write(content);
            // flush输出流的缓冲  
            out.flush();
            httpUrlConnection.connect();
            // 定义BufferedReader输入流来读取URL的响应  
            in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        // 使用finally块来关闭输出流、输入流  
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return response.toString();
    }
}
