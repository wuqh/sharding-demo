package cn.citic.conf;

import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.context.annotation.Configuration;

import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.ComplexShardingStrategyConfiguration;

@Configuration
public class ShardDataSourceConfig {
	
	private void orderTableRule() throws SQLException {
		TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
	    orderTableRuleConfig.setLogicTable("t_order");
	    orderTableRuleConfig.setActualDataNodes("db0.t_order_0, db0.t_order_1, db0.t_order_2, db1.t_order_3, db1.t_order_4");
	    ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
	    shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
	    
	    orderTableRuleConfig.setDatabaseShardingStrategyConfig(new ComplexShardingStrategyConfiguration("order_id", "xxx.ModuloDatabaseShardingAlgorithm"));
	    orderTableRuleConfig.setTableShardingStrategyConfig(new ComplexShardingStrategyConfiguration("order_id", "xxx.ModuloTableShardingAlgorithm"));
	}
	
	

}
