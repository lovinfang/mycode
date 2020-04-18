<script type="text/jsx">
	var hello = React.createClass({
		
		getInitialState:function(){
			alert('init');
			return {
				opacity:1.0,
				fontSize:'12px'
			}
		},
		
		render: function(){
			var styleObj = {
				color : 'red',
				fontSize: '44px'
			};
			
			<!-- return <div style={styleObj}>Hello {this.props.title} {this.props.name}</div> -->
			
			<!-- 从初始化状态中获取定义的css样式的值-->
			return <div style={{opacity:this.state.opacity,fontSize:this.state.fontSize}}>Hello {this.props.title} {this.props.name}</div>
		}
		
		componentWillMount:function(){
			alert('will');
		}
		
		componentDidMount:function(){
			alert('did');
			
			<!-- 设置定时任务1秒后修改state的值 -->
			var _self = this;
			window.setTimeout(function(){
				_self.setState({
					opacity:0.5,
					fontSize:'44px'
				});
			},1000);
		}
	});


	React.render(<Hello name="World" title="Mis">,document.getElementById('container'));

	document.getElementById('container').style.paddingleft = "104px";
</script>

