package org.gnuhpc.bigdata;

import kafka.admin.AdminClient;
import kafka.common.ErrorMapping;
import kafka.common.OffsetMetadataAndError;
import kafka.common.TopicAndPartition;
import kafka.coordinator.GroupOverview;
import kafka.javaapi.OffsetFetchRequest;
import kafka.javaapi.OffsetFetchResponse;
import kafka.network.BlockingChannel;
import kafka.utils.ZkUtils;
import lombok.extern.log4j.Log4j;
import org.apache.curator.framework.CuratorFramework;
import org.gnuhpc.bigdata.model.BrokerInfo;
import org.gnuhpc.bigdata.service.KafkaAdminService;
import org.gnuhpc.bigdata.utils.KafkaUtils;
import org.gnuhpc.bigdata.utils.ZookeeperUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Log4j
public class KafkaRestSpringbootApplicationTests {

	@Autowired
	private KafkaAdminService kafkaAdminService;

	@Autowired
	private ZookeeperUtils zookeeperUtils;

	@Autowired
    private KafkaUtils kafkaUtils;

	private ZkUtils zkUtils;

	private CuratorFramework zkCuratorClient;
	@Before
	public void before(){
		this.zkUtils = zookeeperUtils.getZkUtils();
		this.zkCuratorClient = zookeeperUtils.getCuratorClient();
	}

	@Test
	public void contextLoads() {
		return;
	}

	@Test
	public void testListBrokers() throws Exception {
		List<BrokerInfo> brokerInfoList = kafkaAdminService.listBrokers();
		brokerInfoList.stream().forEach(log::info);
	}
}
